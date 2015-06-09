(ns stem-bearing.core-test
  (:require [clojure.test :refer :all]
            [stem-bearing.core :refer :all]))

(deftest test-dissoc-in
  (is (= {:a {:b {:c {:d "D"}}}} (dissoc-in {:a {:b {:c {:d "D", :e "E"}}}} [:a :b :c :e]))))

