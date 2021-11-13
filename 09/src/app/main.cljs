(ns app.main
  (:require [reagent.dom :as rdom]
            [re-frame.core :as rf] ; in-memory database, send events or subscribe
            [app.events :as events]
            [app.views :as views]
            [app.config :as config]))





;; core

(defn dev-setup []
  (when config/debug?
    (println "dev mode")))

(defn ^:dev/after-load mount-root []
  (rf/clear-subscription-cache!)
  (let [root-el (.getElementById js/document "app")]
    (rdom/unmount-component-at-node root-el)
    (rdom/render [views/main-panel]
                 root-el)))

(defn ^:export main []
  (println "[main]: loading")
  (rf/dispatch-sync [::events/initialize-db])
  (dev-setup)
  (mount-root))


;; interactive browsing of re-frame database

(comment
  (require '[re-frame.db])
  (-> @re-frame.db/app-db)
  )