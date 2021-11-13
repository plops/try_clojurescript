(ns app.events
  (:require
   [re-frame.core :as rf]
   [app.db :as db]
   [day8.re-frame/http-fx]
   [ajax.core :as ajax]
   [day8.re-frame.tracing :refer-macros [fn-traced]]))

(rf/reg-event-db
 ::initialize-db
 (fn-traced [_ _]
            db/default-db))