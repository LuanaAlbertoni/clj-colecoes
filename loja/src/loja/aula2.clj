(ns loja.aula2)

; ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]


(defn conta
  [total-ate-agora elementos]
  (recur (inc total-ate-agora) (rest elementos)))


;(println (conta 0 ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))

(defn conta
  [total-ate-agora elementos]
  (if (next elementos)
    (recur (inc total-ate-agora) (next elementos))))

;(println (conta 0 ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))


(defn conta
  [total-ate-agora elementos]
  (if (next elementos)
    (recur (inc total-ate-agora) (next elementos))
    total-ate-agora))

;resultado 5 (falta somar um)
(println (conta 0 ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))


;incrementa 1 no else
(defn conta
  [total-ate-agora elementos]
  (if (next elementos)
    (recur (inc total-ate-agora) (next elementos))
    (inc total-ate-agora)))

(println (conta 0 ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))
;devolve 1 quando nao tem nenhum campo
(println (conta 0 []))


;utilizar seq para garantir se existe elementos no vetor (uma vez que se nao tiver seria nil)
(defn conta
  [total-ate-agora elementos]
  (if (seq elementos)
    (recur (inc total-ate-agora) (next elementos))
    total-ate-agora))


;(println (conta 0 ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))
;(println (conta 0 []))


(println "\n\n minha-funcao")
(defn minha-funcao
  ([parametro1] (println "p1" parametro1))
  ([parametro1 parametro2] (println "p2" parametro1 parametro2)))

;(minha-funcao 1)
;(minha-funcao 1 2)


(defn conta
  ([elementos] (conta 0 elementos))
  ([total-ate-agora elementos]
   (if (seq elementos)
     (recur (inc total-ate-agora) (next elementos))
     total-ate-agora)))

;(println (conta  ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))
;(println (conta []))





(defn conta
  [elementos]
  (loop [total-ate-agora 0
         elementos-restantes elementos]
    (if (seq elementos-restantes)
      (recur (inc total-ate-agora) (next elementos-restantes))
    total-ate-agora)))


(println (conta  ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))
(println (conta []))








