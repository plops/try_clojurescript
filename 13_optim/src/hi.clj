(ns hi
  (:import (org.apache.commons.math3.fitting GaussianCurveFitter WeightedObservedPoints)
           (org.knowm.xchart XYChart QuickChart SwingWrapper)))

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

(QuickChart/getChart "sample chart"
                     "x"
                     "y"
                     "y(x)" 
                     (double-array 3 [0 1 2])
                     (double-array 3 [2 1 0.1])
                     )
(type (into-array ^double (map double [2 1 0.1])))

(double-array 3 [2 1 0.1])

(type QuickChart/getChart)

(clojure.pprint/print-table
 (sort-by :name
  (filter :exception-types
          (:members (clojure.reflect/reflect QuickChart)))))



;; (comment
;;  (let [obs (WeightedObservedPoints.)]
;;    (.add obs 4.024 531026.0)
;;    (.add obs 4.05325 3580526.0)
;;    (.add obs 4.06943 2175960.0)
;;    (.add obs 4.07525 1447024.0)
;;    (.add obs 4.0836 620014.0)
;;    (let [params (-> (GaussianCurveFitter/create)
;;                     (.fit (.toList obs)))]
;;      (list (aget params 0)
;;            (aget params 1)
;;            (aget params 2)))
;;    ))
;; (comment
;;  (type GaussianCurveFitter))

;; `
