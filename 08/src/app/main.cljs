(ns app.main
  (:require [reagent.dom :as rdom]
            [re-frame.core :as rf] ; in-memory database, send events or subscribe
            ))



;; events

(rf/reg-event-db
 :theme
 (fn [db [_ theme]]
   (assoc-in db [:theme :active]
             theme)))

(rf/reg-event-fx
 :toggle-theme
 (fn [_ [_ on?]]
   {:dispatch [:theme (if on?
                        :light
                        :dark)]}))

;; subscriptions

(def <sub (comp deref rf/subscribe))

(rf/reg-sub
  :light-theme?
  (fn [db _]
    (= :light (get-in db [:theme :active]))))

;; main

(defn ^:dev/after-load reload! []
  (println "[main]: reload"))

(defn toggle-theme [e]
  (rf/dispatch [:toggle-theme (-> e
                                  .-target
                                  .-checked)]))

(defn theme-toggle-field []
  [:input.theme-switch {:type "checkbox"
                        ;:class-name "theme-switch"
                        :id "theme-toggle"
                        :on-change toggle-theme}])

(defn theme-toggle-label []
  [:label.switch-label
   {;:class-name "switch-label"
    :for "theme-toggle"}])

(defn greeting [light-theme?]
  [:h1 (if light-theme?
         "Good day"
         "Good evening")])

(defn page []
  [:<>
   [theme-toggle-field]
   [:div#page ; {:id "page"}
    [theme-toggle-label]
    [greeting (<sub [:light-theme?])
     ;@(rf/subscribe [:light-theme?])
     ]]])

(defn main-element []
  (-> js/document 
      (.getElementById "app")))

(defn ^:export main []
  (println "[main]: loading")
  (rdom/render [page]
               (main-element)))


;; interactive browsing of re-frame database

(comment
  (require '[re-frame.db])
  (-> @re-frame.db/app-db)
  )