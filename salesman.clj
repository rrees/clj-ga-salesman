(def routes {"ab" 2, 
             "ba" 3, 
             "cb" 4, 
             "bc" 4, 
             "ca" 5, 
             "ac" 2, 
             "dc" 9, 
             "cd" 7})

routes

(defn
#^{
  :doc "Calculates the cost of a given route"
  :test (fn []
              (assert
               (= "jeff" (cost))))}
  cost [route] 
    (reduce + (route-costs route)))

(defn route-costs [rs]
  (map (fn [r] (routes r)) rs))

;(reduce + (route-costs ["ab" "bc"]))


(defn first-connection-to [s]
(key 
(first
(filter (fn [keyval] (= (first (key keyval)) \a)) routes))))

(defn plan-route [start end]
   (if (routes (str start end))
      [(str start end)]
      [(first-connection-to start) 
        (plan-route (last (first-connection-to start)) end)] ))
(key (first routes))


(assert (= ["ab"] (plan-route "a" "b")))
(assert (= ["cb"] (plan-route "c" "b")))
(assert (not= ["ad"] (plan-route "a" "d")))

(assert (and 
  (= (first (first (plan-route "a" "d"))) \a)
  (= (last (last (plan-route "a" "d"))) \d)))

(assert (and 
  (= (first (first (plan-route "b" "d"))) \b)
  (= (last (last (plan-route "b" "d"))) \d)))



(contains? routes "ab" )

(assert (= 13 (cost ["dc" "cb"])))
(assert (= 6 (cost ["ac" "cb"])))
(assert (= 21 (cost ["cd" "dc" "ca"])))
(assert (= 23 (cost ["cd" "dc" "ca" "ab"])))





