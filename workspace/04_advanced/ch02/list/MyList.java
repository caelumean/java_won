package ch02.list;

/**
 * MyArray / MyLinkedList는 메소드 이름은 공통화 할 수 있지만
 * 내부코드는 공통화 할 수 없기 때문에 interface로 만든다
 */
public interface MyList<T> {

    /**
     * 지정한 데이터를 마지막 요소로 추가한다.
     * @param obj 추가할 데이터
     */
    void add(T obj);

    /**
     * 지정한 데이터를 index 위치에 삽입한다.
     * @param index
     * @param obj
     */
    void add(int index, T obj);

    /**
     * 지정한 index의 데이터를 삭제한다.
     * @param index
     */
    void remove(int index);

    /**
     * 지정한 index의 데이터를 조회한다.
     * @param index 조회할 데이터
     * @return
     */

    T get(int index);

    /**
     * 데이터의 수를 반환한다.
     * @return
     */
    int size();


}
