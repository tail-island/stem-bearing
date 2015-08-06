(ns stem-bearing.core
  (:require (clojure [pprint :as pprint])))

(defmacro pprint-macro
  [form]
  `(pprint/pprint (macroexpand-1 '~form)))

(defmacro with-map-bindings
  [binding-forms function & body]
  `(let [[~@binding-forms] (map ~function [~@binding-forms])]
     ~@body))

(defn flip
  [function]
  (fn [arg & more] (apply function (concat more [arg]))))

(defn dissoc-in
  "Dissociates a value in a nested associative structure, and returns a new map that does not contain a mapping for keys."
  [map [key & more]]
  (if more
    (assoc  map key (dissoc-in (get map key) more))
    (dissoc map key)))

(defn pformat
  "Format an object with pprint formatter."
  [object]
  (->> (with-out-str
         (pprint/pprint object))
       (butlast)
       (apply str)))
