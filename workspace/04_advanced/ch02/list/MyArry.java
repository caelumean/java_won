package ch02.list;

/**
 * 배열의 불편한 점
 *  생성시 길이를 지정해야 함
 *  생성된 배열의 길이는 수정 못함
 *  요소 추가, 삭제 , 삽입이 어려움
 *
 *  이러한 불편한 점을 개선하여 배열을 쓰기 쉽게 만드는 클래스
*/
public class MyArry {

    /**
     * 내부적으로 요소를 저장하는 배열 선언
     */

    private  Object[] data;
    /**
     * 배열의 실제 담겨있는 요소의 개수
    */

    private int count;
    /**
     * 기본 생성자
     * 초기 배열의 크기를 10개로 지정한다.
     */
    public MyArry(){
        this(10);

    }

    /**
     * 초기 배열의 크기를 지정한 size로 생성한다.
     * @param size 배열의 초기 크기
     */
    public MyArry(int size){
        data = new Object[size];

    }
    /**
     * 배열의 마지막 위치에 지정한 elem를 추가한다.
     * @param elem 배열에 추가할 요소
     */
    public void append(Object elem){
        append(count, elem);
    }
    /**
     * 배열의 index에 elem를 삽입한다.
     * @param index 삽입할 위치
     * @param elem 삽입할 요소
     */
    public void append(int index, Object elem){
        // 내부 배열의 공간이 다 찼을 경우 예외 발생
//        if(count >= data.length){
//            // 배열의 범위를 벗어난 걸 요청할 때 이러한 메세지를 던져준다
//            throw new ArrayIndexOutOfBoundsException("더이상 추가할 수 없습니다.");
//        }
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(index + "< 0");
        }else if(index >  count){
            throw new ArrayIndexOutOfBoundsException(index + " > " +count);
        }

        // 내부 배열의 공간이 다 찼을 경우 배열의 크기를 늘린다.
        if( count >= data.length){
            Object[] temp = new Object[data.length + data.length/2];

            for(int i=0; i<data.length; i++){
                temp[i] = data[i];
            }
            System.out.println(data.length + " -> " + temp.length);
            data = temp;
        }
        // 옆으로 한칸 미는 작업
        // index부터 끝까지 하나씩 뒤로 미는 작업
        // 원본배열 / 원본 애열에서 복사를 시작할 인덱스
        // (대상 배열)데이터가 복사될 배열 / 대상 배열에서 데이터를 저장할 시작 인덱스
        // 복사할 요소의 개수
        System.arraycopy(data, index, data, index+1, count - index);
        data[index] = elem;
        count++;
    }

    /**
     * 지정한 index의 요소를 삭제한다.
     * @param index
     */
    public void delete(int index){

        if(index >= count){
            // 배열의 범위를 벗어난 걸 요청할 때 이러한 메세지를 던져준다
            throw new ArrayIndexOutOfBoundsException(index + " >= " +count);
        } else if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(index + "< 0");
        }
        // 옆으로 한칸 미는 작업
        // index부터 끝까지 하나씩 뒤로 미는 작업
        System.arraycopy(data, index+1, data, index ,count - index -1);
        count--;
        data[count] = null;

    }

    /**
     * 지정한 위치의 데이터를 반환
     * @param index 반환할 데이터의 위치
     * @return 지정한 위치의 데이터
     */
    public Object getElem(int index){

        if(index >= count){
            // 배열의 범위를 벗어난 걸 요청할 때 이러한 메세지를 던져준다
            throw new ArrayIndexOutOfBoundsException(index + " >= " +count);
        } else if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(index + "< 0");
        }
        return data[index];
    }
    public int size(){
//        int size = count;
//        return size;
        return this.count;
    }

    @Override
    public String toString(){
//        return Arrays.toString(data);
        // 배열안에 있는 요소를 count까지만 꺼내기
        // StringBuffer는 힙에 한 번 만들어지고
        // 그 뒤에 문자열을 붙이기 때문에 String보다 효율적이다.
        // 멀티 스레드 환경에서 사용
//        StringBuffer str =new StringBuffer("[");
        // 싱글 스레드 환경에서 사용
        StringBuilder str = new StringBuilder("[");

        if(count > 0) {
            str.append(data[0]);
        }

        for(int i=1;i<count;i++){
            str.append(", ").append(data[i]);
        }
        str.append("]");

        return str.toString();
    }


}
