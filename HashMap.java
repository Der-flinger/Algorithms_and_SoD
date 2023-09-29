/**
 * Структура хэш-таблица
 * 
 * @param <k> тип ключа
 * @param <v> тип значения
 */
public class HashMap<k, v> {

    // region Публичные методы
    public v put(k key, v value) {
        int index = calculateBucketIndex(key);
        Bucket bucket = buckets[index];
        if (bucket == null) {
            bucket = new Bucket();
            buckets[index] = bucket;
        }

        Entity entity = new Entity();
        entity.key = key;
        entity.value = value;

        return (v) bucket.add(entity);
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("{");
        for (int i = 0; i < buckets.length; i++) {
            Bucket<k, v> bucket = buckets[i];
            if (bucket != null) {
                Bucket.Node node = bucket.head;
                while (node != null) {
                    str.append(String.format("%s: %s, ", node.value.key.toString(), node.value.value.toString()));
                    node = node.next;
                }
            }
        }
        str.replace(str.length() - 2, str.length(), "}");
        return str.toString();
    }

    // endregion

    // region Служебные методы

    private int calculateBucketIndex(k key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    // endregion

    // region Константы
    private static final int INIT_BUCKET_COUNT = 16;
    // endregion

    // region Конструкторы
    public HashMap() {
        buckets = new Bucket[INIT_BUCKET_COUNT];
    }

    public HashMap(int initCount) {
        buckets = new Bucket[initCount];
    }
    // endregion

    // region Поля
    /*
     * Массив бакетов (связных)
     */
    private Bucket[] buckets;
    // endregion

    // region Вспомогательные элементы
    /*
     * Элемент хэш-таблицы
     */
    class Entity {

        /*
         * Ключ
         */
        k key;

        /*
         * Значение
         */
        v value;
    }

    /*
     * Элемент массива (связный список) из которого состоит хэш-таблица
     */
    class Bucket<k, v> {

        /*
         * Указатель на первый элемент списка
         */
        private Node head;

        /*
         * Узел связного списка
         */
        class Node {

            /*
             * Ссылка на следующий узел (если имеется)
             */
            public Node next;

            /*
             * Значение узла
             */
            Entity value;

        }

        public v add(Entity entity) {
            Node node = new Node();
            node.value = entity;

            if (head == null) {
                head = node;
                return null;
            }

            Node currentNode = head;
            while (true) {
                if (currentNode.value.key.equals(entity.key)) {
                    v buf = (v) currentNode.value.value;
                    currentNode.value.value = entity.value;
                    return buf;
                }

                if (currentNode.next != null) {
                    currentNode = currentNode.next;
                } else {
                    currentNode.next = node;
                    return null;
                }
            }
        }
    }
    // endregion
}
