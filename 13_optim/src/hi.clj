(ns hi
  (:import (org.apache.commons.math3.fitting GaussianCurveFitter WeightedObservedPoints)))

(defn -main [& _]
  (let [obs (WeightedObservedPoints.)]
  (.add obs 4.024 531026.0)
  (.add obs 4.05325 3580526.0)
  (.add obs 4.06943 2175960.0)
  (.add obs 4.07525 1447024.0)
  (.add obs 4.0836 620014.0)
  (let [params (-> (GaussianCurveFitter/create)
                   (.fit (.toList obs)))]
    (println "fit result:" (list (aget params 0)
                                 (aget params 1)
                                 (aget params 2))))
  ))

(comment
 (let [obs (WeightedObservedPoints.)]
   (.add obs 4.024 531026.0)
   (.add obs 4.05325 3580526.0)
   (.add obs 4.06943 2175960.0)
   (.add obs 4.07525 1447024.0)
   (.add obs 4.0836 620014.0)
   (let [params (-> (GaussianCurveFitter/create)
                    (.fit (.toList obs)))]
     (list (aget params 0)
           (aget params 1)
           (aget params 2)))
   ))
(comment
 (type GaussianCurveFitter))

