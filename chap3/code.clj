(if true
  "By Zeru's Hammer!"
  "By Aquamans Trident!")

(if  (=  1 "blah")
  "this is true"
  "this is not true")

(defn error-message
  [severity]
  (str "OH GOD! IT'S A DISASTER WE'RE "
    (if (= severity :mild)
      "MILDLY INCONVENIENCED!"
      "DOOOOOMED")))

(defn add-numbers
  [num1 num2]
  (+ num1 num2))

(def yo (str "lo"))

(defn addhundo
  [number-to-add-hundo-to]
  (+ number-to-add-hundo-to 100))

(:cali (hash-map :michigan 8.3 :ohio 9))

(defn mapset
  [function & things]
  (into #{} (map function (into [] things) )))

(defn create-vector
  [& things]
  (into [] things))

(defn do-something
  [function num1 num2]
  (function num1 num2))

(defn dec-maker
  "Create a custom decrementer"
  [dec-by]
  #(- % dec-by))

(def dec9 (dec-maker 9))


;; Hobbit violence!
(def asym-hobbit-body-parts [{:name "head" :size 3}
                             {:name "left-eye" :size 1}
                             {:name "left-ear" :size 1}
                             {:name "mouth" :size 1}
                             {:name "nose" :size 1}
                             {:name "neck" :size 2}
                             {:name "left-shoulder" :size 3}
                             {:name "left-upper-arm" :size 3}
                             {:name "chest" :size 10}
                             {:name "back" :size 10}
                             {:name "left-forearm" :size 3}
                             {:name "abdomen" :size 6}
                             {:name "left-kidney" :size 1}
                             {:name "left-hand" :size 2}
                             {:name "left-knee" :size 2}
                             {:name "left-thigh" :size 4}
                             {:name "left-lower-leg" :size 3}
                             {:name "left-achilles" :size 1}
                             {:name "left-foot" :size 2}])


(defn matching-part
  [part]
  {:name (clojure.string/replace (:name part) #"^left-" "right-")
   :size (:size part)})

(defn symmetrize-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts]
  (loop [remaining-asym-parts asym-body-parts
         final-body-parts []]
    (if (empty? remaining-asym-parts)
      final-body-parts
      (let [[part & remaining] remaining-asym-parts]
        (recur remaining
               (into final-body-parts
                     (set [part (matching-part part)])))))))

(defn better-symmetrize-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts]
  (reduce (fn [final-body-parts part]
      (into final-body-parts (set [part (matching-part part)])))
    []
    asym-body-parts))


(defn hit
  [asym-body-parts]

  (let [sym-parts (better-symmetrize-body-parts asym-body-parts)
        body-part-size-sum (reduce + (map :size sym-parts))
        target (rand body-part-size-sum)]
        (loop [[part & remaining] sym-parts
          accumulated-size (:size part)]
        (if (> accumulated-size target)
          part
          (recur remaining (+ accumulated-size (:size (first remaining))))))))
