(ns app.main)
;; (ns ^:figwheel-hooks hello.app
;;   (:require [reagent.dom :as rdom]))

;; (defn ^:after-load re-render []
;;   (js/console.log "after load rerender"))

(defn main! []
  (println "[main]: loading"))

(defn ^:dev/after-load reload! []
  (println "[main]: reload"))

;; (defn theme-toggle-field []
;;   [:input {:type "checkbox"
;;            :class-name "theme-switch"
;;            :id "theme-toggle"}])

;; (defn theme-toggle-label []
;;   [:label {:class-name "switch-label"
;;            :for "theme-toggle"}])

;; (defn page []
;;   [:<>
;;    [theme-toggle-field]
;;    [:div {:id "page"}
;;     [theme-toggle-label]]])

;; (defn main-element []
;;   (-> js/document (.getElementById "app")))

;; (defn ^:export main []
;;   (rdom/render [page]
;;                (main-element)))