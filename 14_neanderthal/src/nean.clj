(ns nean
  (:use
   [uncomplicate.neanderthal core native])
 #_ (:require
   [uncomplicate.neanderthal.core :as unc :refer (axpy mm scal mv)]
   [uncomplicate.neanderthal.linalg :as unl]
   [uncomplicate.neanderthal.math :as unm :refer (cos sin)]
   [uncomplicate.neanderthal.native :as unn :refer (dv dge)]
   [uncomplicate.neanderthal.random :as unr]
   ))

(def x (dv 1 2 3))
