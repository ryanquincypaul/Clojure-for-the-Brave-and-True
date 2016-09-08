;;Exercise 1
;str
(def yolo (str "you only live once"))

;vector

;list

;hash-map

;hash-set

;;Exercise 2
(defn add-a-benji
  "Add a benji (hundo, franklin, etc.) to a number"
  [number-to-add-benji-to]
  (+ number-to-add-benji-to 100))

;;Exercise 3
(defn dec-maker
  "Create a custom decrementer"
  [dec-by]
  #(- % dec-by))

(def dec9 (dec-maker 9))

;;Exercise4
(defn mapset
  [function & things]
  (into #{} (map function (into [] things) )))

;;Exercise 5


