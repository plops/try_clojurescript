(ns app.views
  (:require
   [re-frame.core :as rf]
   [app.events :as events]
   [app.subs :as subs]))

(defn display-user [{:keys [id avatar email]
                     first-name :first-name}]
  [:div.horizontal {:key id}
   [:img.pr-15 {:src avatar}]
   [:div
    [:h2 first-name]
    [:p (str "(" email")")]]])

(defn main-panel []
  (let [name (rf/subscribe [::subs/name])
        loading (rf/subscribe [::subs/loading])
        users (rf/subscribe [::subs/users])]
    [:div
     [:h1
      "Hello from" @name]
     (when @loading
       "Loading ...")
     (map display-user
          @users)
     [:button
      {:on-click 
       #(rf/dispatch [::events/fetch-users])}
      "Make API call"]
     [:button
      {:on-click
       #(rf/dispatch [::events/update-name "bla"])}
      "Update name"]]))