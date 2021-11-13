(ns app.events
  (:require
   [re-frame.core :as rf]
 ;  [app.db :as db]
   [day8.re-frame.http-fx]
   [ajax.core :as ajax] ;; for use in response-format
  ; [day8.re-frame.tracing :refer-macros [fn-traced]]
   ))

;; (comment
;;   (rf/reg-event-db
;;    ::initialize-db
;;    (fn-traced [_ _]
;;               db/default-db)))



(rf/reg-event-db
 ::update-name
 (fn [db [_ val]]
   (assoc db :name val)))

;; from https://github.com/day8/re-frame-http-fx
(reg-event-fx                             ;; note the trailing -fx
 :handler-with-http                      ;; usage:  (dispatch [:handler-with-http])
 (fn [{:keys [db]} _]                    ;; the first param will be "world"
   {:db   (assoc db :show-twirly true)   ;; causes the twirly-waiting-dialog to show??
    :http-xhrio {:method          :get
                 :uri             "https://api.github.com/orgs/day8"
                 :timeout         8000                                           ;; optional see API docs
                 :response-format (ajax/json-response-format {:keywords? true})  ;; IMPORTANT!: You must provide this.
                 :on-success      [:good-http-result]
                 :on-failure      [:bad-http-result]}}))