(ns app.main
  (:require [reagent.dom :as rdom]
            ;[re-frame.core :as rf]
            ))


;(defn main! []
;  (println "[main]: loading"))

(defn ^:dev/after-load reload! []
  (println "[main]: reload"))

(defn theme-toggle-field []
  [:input.theme-switch {:type "checkbox"
                        ;:class-name "theme-switch"
                        :id "theme-toggle"}])

(defn theme-toggle-label []
  [:label.switch-label
   {;:class-name "switch-label"
    :for "theme-toggle"}])

(defn greeting []
  [:h1 "Good Evening"])

(defn page []
  [:<>
   [theme-toggle-field]
   [:div#page ; {:id "page"}
    [theme-toggle-label]
    [greeting]]])

(defn main-element []
  (-> js/document 
      (.getElementById "app")))

(defn ^:export main []
  (println "[main]: loading")
  (rdom/render [page]
               (main-element)))