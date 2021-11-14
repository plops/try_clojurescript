(ns app.events
  (:require
   [re-frame.core :as rf]
   [app.db :as db]
   [day8.re-frame.http-fx]
   [ajax.core :as ajax] ;; for use in response-format, convert json response back into clojure map
   [day8.re-frame.tracing :refer-macros [fn-traced]]))


(rf/reg-event-db
 ::initialize-db
 (fn-traced [_ _]
            db/default-db))

(rf/reg-event-db
 ::update-name
 (fn [db [_ val]]
   (assoc db :name val)))

;; from https://github.com/day8/re-frame-http-fx
(rf/reg-event-fx                             ;; note the trailing -fx
 ::fetch-users                ;; usage:  (dispatch [:handler-with-http])
 (fn [{:keys [db]} _]                    ;; the first param will be "world"
   {:db   (assoc db :loading true)   ;; causes the twirly-waiting-dialog to show??
    :http-xhrio {:method          :get
                 ;; get some fake data
                 :uri             "https://reqres.in/api/users?page=2"
                 :timeout         8000                      ;; optional see API docs
                 ;:mode "cors" ;; https://developer.mozilla.org/en-US/docs/Web/API/Request#properties
                 :response-format (ajax/json-response-format
                                   {:keywords? true})  ;; IMPORTANT!: You must provide this.
                 :on-success      [::fetch-users-success]
                 :on-failure      [:bad-http-result]}}))

;; store user on success
(rf/reg-event-db
 ::fetch-users-success
 (fn [db [_ {:keys [data]}]]
   (-> db
       (assoc :loading false)
       (assoc :users data))))