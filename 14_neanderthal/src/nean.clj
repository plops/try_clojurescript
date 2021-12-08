(ns nean
  (:require
   [uncomplicate.neanderthal.linalg :as unl]
     )
  (:use
   [uncomplicate.neanderthal core native random math])
  
 #_ (:require
   [uncomplicate.neanderthal.core :as unc :refer (axpy mm scal mv)]
   [uncomplicate.neanderthal.linalg :as unl]
   [uncomplicate.neanderthal.math :as unm :refer (cos sin)]
   [uncomplicate.neanderthal.native :as unn :refer (dv dge)]
   [uncomplicate.neanderthal.random :as unr]
   ))

(def x (dv 1 2 3))

(def xs [(dv [1 2 3])
         (dv [1 2 3])
         (dv 3)])

(defn rand-vec [n]
  (let [x (rand-uniform! (dv n))]
    (scal (/ 1 (nrm2 x))
          x)))

(rand-vec 31)


(def zz (rand-normal! (dge 3 2)))
zz

(unl/ev! (rand-normal! (dge 3 3)))

(axpy x x)

(rand-normal! (dge 3 2))

(unl/svd (rand-normal! (dge 3 3)))

(unl/svd! (rand-normal! (dge 3 2))
          3)

(dge 2 2)

(unl/ls (rand-normal! (dge 2 2))
        (rand-normal! (dv 2)))
