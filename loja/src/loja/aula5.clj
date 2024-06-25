(ns loja.aula5
  (:require [loja.db :as l.db]
            [loja.logic :as l.logic]))


(defn gastou-bastante? [info-do-usuario]
  (> (:preco-total info-do-usuario) 500))

(let [pedidos (l.db/todos-os-pedidos)
      resumo (l.logic/resumo-por-usuario pedidos)]
  (println "Keep" (keep gastou-bastante? resumo))
  (println "filter" (filter gastou-bastante? resumo))
  )


(println "\n\n Dentro do keep e do filter")
(defn gastou-bastante? [info-do-usuario]
  (println "gastou bastante?" (:usuario-id info-do-usuario))
  (> (:preco-total info-do-usuario) 500))

(let [pedidos (l.db/todos-os-pedidos)
      resumo (l.logic/resumo-por-usuario pedidos)]
  (println "Keep" (keep gastou-bastante? resumo))
  ;(println "filter" (filter gastou-bastante? resumo))
  )

(println "\n isolando....")

(println (range 10))
;a sequencia seguinte na esta sendo eager, ela carrega o que precisa (lazy)
(println (take 2 (range 10000)))

;segue sendo LAZY (preguicosa)
(let [sequencia (range 10000)]
  (println (take 2 sequencia))                              ; imutabilidade, sequencia eh a mesma
  (println (take 2 sequencia))
  )

(defn filtro1 [x]
  (println "filtro1" x)
  x)

(println (map filtro1 (range 10)))

(defn filtro2 [x]
  (println "filtro1" x)
  x)

(println (map  filtro2 (map filtro1 (range 10))))

(->> (range 10)
     (map filtro1)
     (map filtro2)
     println)

(println "\n\n range maior...")

;CHUNKS DE 32
(->> (range 50)
     (map filtro1)
     (map filtro2)
     println)

;PESQUISAR:: mapv
(->> (range 50)
     (mapv filtro1)
     (mapv filtro2)
     println)

(->> [0 1 2 3 4 5 6 7 8 9 0 0 1 2 3 4 5 6 7 8 9 0 0 1 2 3 4 5 6 7 8 9 0 1 2 3 ]
     (map filtro1)
     (map filtro2)
     println)

; lista ligada foi 100% lazy nesse cenario
(->> '(0 1 2 3 4 5 6 7 8 9 0 0 1 2 3 4 5 6 7 8 9 0 0 1 2 3 4 5 6 7 8 9 0 1 2 3)
     (map filtro1)
     (map filtro2)
     println)