(ns app.subs
  {:require
   [re-frame.core :as rf]})

(rf/reg-sub
 ::name
 (fn [db]
   (:name db)))

(rf/reg-sub
 ::loading
 (fn [db]
   (:loading db)))

(rf/reg-sub
 ::users
 (fn [db]
   (:users db)))