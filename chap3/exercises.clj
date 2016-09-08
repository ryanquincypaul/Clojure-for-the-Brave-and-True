;;Exercise 1
;str
(def yolo (str "you only live once"))

;vector
(def vecto-cooler [1 2 3 4 5])
;list
(def listo '(1 2 3 4 5))
;hash-map
(def hashish (hash-map :a 1 :b 2 :yo "lo"))
;hash-set
(def hashishset (hash-set 1 1 2 3))

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

(defn matching-part-alien
  [part part-number]
  {:name (clojure.string/replace (:name part) #"[0-9]$" (str part-number))
   :size (:size part)})

(defn better-symmetrize-body-parts-aliens
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts]
  (reduce (fn [final-body-parts part]
            (into final-body-parts (loop [iteration 1] 
                                       (def parts-set #{})
                                       (conj parts-set [part (matching-part-alien part iteration)])
                                       (if (> iteration 5)
                                        parts-set 
                                          (recur (inc iteration))))))
          []
          asym-body-parts))

(defn alienlooptester
  [part]
  (into []
        (loop [iteration 1]
          (set [part (matching-part-alien part iteration)])
          (if (< 6 iteration)
            (recur (inc iteration))))))

  ;;Exercise 6

  ;;Hobbit parts for 5 and 6
  ;; Hobbit violence!



(def asym-alien-body-parts [{:name "head" :size 3}
                            {:name "eye-1" :size 1}
                            {:name "ear-1" :size 1}
                            {:name "mouth" :size 1}
                            {:name "nose" :size 1}
                            {:name "neck" :size 2}
                            {:name "shoulder-1" :size 3}
                            {:name "upper-arm-1" :size 3}
                            {:name "chest" :size 10}
                            {:name "back" :size 10}
                            {:name "forearm-1" :size 3}
                            {:name "abdomen" :size 6}
                            {:name "kidney-1" :size 1}
                            {:name "hand-1" :size 2}
                            {:name "knee-1" :size 2}
                            {:name "thigh-1" :size 4}
                            {:name "lower-leg-1" :size 3}
                            {:name "achilles-1" :size 1}
                            {:name "foot-1" :size 2}])

