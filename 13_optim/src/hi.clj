(ns hi
  (:import (org.apache.commons.math3.fitting GaussianCurveFitter WeightedObservedPoints)))

(defn -main [& _]
  (println "hello"))

(let [obs (WeightedObservedPoints.)]
  (.add obs 4.024 531026.0)
  obs)
