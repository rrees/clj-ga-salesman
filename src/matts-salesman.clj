(def routes {

'(a b) 2,

'(b a) 3,

'(c b) 4,

'(b c) 4,

'(c a) 5,

'(a c) 2,

'(d c) 9,

'(c d) 7})

(defn

#^{:doc "List of immediate targets for a location"

:test (fn [] (assert (= '(b c) (targets 'a))))}

targets[src]

(map (comp second key)

(filter (fn [keyval]

(= 'a (first

(key keyval))))

routes)))

(test #'targets)

(defn

#^{

:doc "Scores a given route"

:test (fn [] (assert (and (= 7 (score '(c d)))

(nil? (score '(d e))))))}

score[route]

(get routes route))

(test #'score) 