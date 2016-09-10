(ns fwpd.core)
(def vampfile "suspects.csv")

(def vamp-keys [:name :glitter-index])

(defn str->int
  [str]
  (Integer. str))

(def conversions {:name identity :glitter-index str->int})

(defn convert
  [vamp-key value]
  ((get conversions vamp-key) value))

(defn parse
  "Convert a CSV into rows of columns"
  [string]
  (map #(clojure.string/split % #",")
    (clojure.string/split string #"\n")))

(defn mapify
  "Return a seq of maps like {:name \"Edward Cullen\" :glitter-index 10}"
  [rows]
  (map (fn [unmapped-row]
    (reduce (fn [row-map [vamp-key value]]
      (assoc row-map vamp-key (convert vamp-key value)))
      {}
      (map vector vamp-keys unmapped-row)))
    rows))

(def suspect-key-validations {:name is-present :glitter-index is-present})

;;Exercise 1
(defn glitter-filter
  "Return a list of names of people that glitter"
  [minimum-glitter records]
  (map :name (filter #(>= (:glitter-index %) minimum-glitter) records)))

;;Exercise 2
(defn append
  "Add a suspect to a list of suspects"
  [suspects suspect-to-add]
  (if (validate suspect-key-validations suspect-to-add)
    (conj suspects suspect-to-add)))

;;Exercise 3
(defn is-present
  "check if a field is present in a map"
  [record keyname]
  (not (nil? (record keyname))))

(defn validate
  "Takes a map of validation funtions used to validate those keys on an instance of the map"
  [validation-functions record]
  (apply = true (map  (fn [onekey] ((get validation-functions onekey) record onekey) )  (keys validation-functions))))

;;Added to exercise 2 above

;;Exercise 4
(defn suspect-to-text
  "Take a suspect record and create comma delimited line"
  [suspect]
  (str (get suspect :name) "," (get suspect :glitter-index)))

(defn write-suspects-to-csv
  "take list of suspects and create csv string"
  [suspects]
  (clojure.string/join "\n" (map suspect-to-text suspects)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
