(ns loja.aula3
  (:require [loja.db :as l.db]))

;(println (l.db/todos-os-pedidos))

;(println (group-by :usuario (l.db/todos-os-pedidos)))

(defn minha-funcao-de-agrupamento
  [elemento]
  (println "elemento" elemento)
  (:usuario elemento))

;(println (group-by minha-funcao-de-agrupamento (l.db/todos-os-pedidos)))

;chave id do usuario, valor um vetor com todos os pedidos
; { 15 [xxx]
;    1 [x]
;   10 [x]
;   20 [x] }

;vai contar apenas a quantidade de chaves
(println (count (vals (group-by :usuario (l.db/todos-os-pedidos)))))

;mapear a quantidade de couts de cada usuario
(println (map count (vals (group-by :usuario (l.db/todos-os-pedidos)))))

(defn conta-total-por-usuario
  [[usuario pedidos]]
  [usuario (count pedidos)]
  )

(->> (l.db/todos-os-pedidos)
     (group-by :usuario)
     (map conta-total-por-usuario)
     println)

(defn conta-total-por-usuario
  [[usuario pedidos]]
  {:usuario-id usuario
   :total-de-pedidos (count pedidos)})

(->> (l.db/todos-os-pedidos)
     (group-by :usuario)
     (map conta-total-por-usuario)
     println)

(println "\nPEDIDOS")

(defn total-do-item
  [[item-id detalhes]]
  (* (get detalhes :quantidade 0) (get detalhes :preco-unitario 0)))

(defn total-do-pedido
  [pedido]
  (reduce + (map total-do-item pedido)))

(defn total-do-pedido
  [pedido]
  (->> pedido
       (map total-do-item)
       (reduce +)))

(defn total-dos-pedidos
  [pedidos]
  (->> pedidos
       (map :itens)
       (map total-do-pedido)
       (reduce +)))

(defn quantia-de-pedidos-e-gasto-total-por-usuario
  [[usuario pedidos]]
  {:usuario-id usuario
   :total-de-pedidos (count pedidos)
   :preco-total (total-dos-pedidos pedidos)})

(->> (l.db/todos-os-pedidos)
     (group-by :usuario)
     (map quantia-de-pedidos-e-gasto-total-por-usuario)
     println)