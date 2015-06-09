(ns stem-bearing.core
  (:require (clojure [pprint :as pprint])))

(defn pformat
  "Format an object with pprint formatter."
  [object]
  (->> (with-out-str
         (pprint/pprint object))
       (butlast)
       (apply str)))

(defn dissoc-in
  "Dissociates a value in a nested associative structure, and returns a new map that does not contain a mapping for keys."
  [map [key & more]]
  (if more
    (assoc  map key (dissoc-in (get map key) more))
    (dissoc map key)))
