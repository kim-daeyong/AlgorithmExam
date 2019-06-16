package Basic.Hash;

public class Hash {

    // 해시는 검색과 더불어 추가삭제에도 좋음
    // 해시법은 데이터를 저장할 위치(인덱스)를 간단한 연산으로 구함
    // 충돌에 대한 대처 - 체인법 - 같은 해시값을 갖는 요소를 연결 리스트로관리, 오픈주소법 빈버킷을 찾을때까지 해시 반복]

    //체인법 - 같은 해시 값을 갖는 데이터를 쇠사슬 모양으로 연결

    /*

package chap11;
// 체인법에 의한 해시

public class ChainHash<K,V> {
	// 해시를 구성하는 노드
	class Node<K,V> {
		private K key;					// 키 값
		private V data;					// 데이터
		private Node<K,V> next;			// 다음 노드에 대한 참조

		// 생성자
		Node(K key, V data, Node<K,V> next) {
			this.key  = key;
			this.data = data;
			this.next = next;
		}

		// 키 값을 반환합니다.
		K getKey() {
			return key;
		}

		// 데이터를 반환합니다.
		V getValue() {
			return data;
		}

		// 키의 해시값을 반환합니다.
		public int hashCode() {
			return key.hashCode();
		}
	}

	private int	size;						// 해시 테이블의 크기
	private Node<K,V>[] table;				// 해시 테이블

	// 생성자
	public ChainHash(int capacity) {
		try {
			table = new Node[capacity];
			this.size = capacity;
		} catch (OutOfMemoryError e) {		// 테이블을 생성할 수 없음
			this.size = 0;
		}
	}

	// 해시값을 구함
	public int hashValue(Object key) {
		return key.hashCode() % size;
	}

	// 키 값 key를 갖는 요소의 검색 (데이터를 반환)
	public V search(K key) {
		int hash = hashValue(key);			// 검색할 데이터의 해시값
		Node<K,V> p = table[hash];			// 선택 노드

		while (p != null) {
			if (p.getKey().equals(key))
				return p.getValue();		// 검색 성공
			p = p.next;						// 다음 노드에 주목
		}
		return null;						// 검색 실패
	}

	// 키 값 key, 데이터 data를 갖는 요소의  추가
	public int add(K key, V data) {
		int hash = hashValue(key);			// 추가할 데이터의 해시값
		Node<K,V> p = table[hash];			// 선택 노드

		while (p != null) {
			if (p.getKey().equals(key))		// 이 키 값은 이미 등록됨
				return 1;
			p = p.next;						// 다음 노드에 주목
		}
		Node<K,V> temp = new Node<K,V>(key, data, table[hash]);
		table[hash] = temp;					// 노드를 삽입
		return 0;
	}

	// 키 값 key를 갖는 요소의 삭제
	public int remove(K key) {
		int hash = hashValue(key);			// 삭제할 데이터의 해시 값
		Node<K,V> p = table[hash];			// 선택 노드
		Node<K,V> pp = null;				// 바로 앞의 선택 노드

		while (p != null) {
			if (p.getKey().equals(key)) {	//  찾으면
				if (pp == null)
					table[hash] = p.next;
				else
					pp.next = p.next;
				return 0;
			}
			pp = p;
			p = p.next;						// 다음 노드를 가리킴
		}
		return 1;							// 그 키 값은 없습니다.
	}

	// 해시 테이블을 덤프
	public void dump() {
		for (int i = 0; i < size; i++) {
			Node<K,V> p = table[i];
			System.out.printf("%02d  ", i);
			while (p != null) {
				System.out.printf("→ %s (%s)  ", p.getKey(), p.getValue());
				p = p.next;
			}
			System.out.println();
		}
	}
}




package chap11;
// 오픈 주소법에 의한 해시

public class OpenHash<K,V> {
	// 버킷의 상태
	enum Status {OCCUPIED, EMPTY, DELETED};		// {데이터 저장, 비어 있음, 삭제 마침}

	// 버킷
	static class Bucket<K,V> {
		private K key;							// 키 값
		private V data;							// 데이터
		private Status stat;					// 상태

		// 생성자
		Bucket() {
			stat = Status.EMPTY;				// 버킷은 비어 있음
		}

		// 모든 필드에 값을 설정합니다.
		void set(K key, V data, Status stat) {
			this.key  = key;					// 키 값
			this.data = data;					// 데이터
			this.stat = stat;					// 상태
		}

		// 상태를 설정합니다.
		void setStat(Status stat) {
			this.stat = stat;
		}

		// 키 값을 반환합니다.
		K getKey() {
			return key;
		}

		// 데이터를 반환합니다.
		V getValue() {
			return data;
		}

		// 키의 해시 값을 반환합니다.
		public int hashCode() {
			return key.hashCode();
		}
	}

	private int size;						// 해시 테이블의 크기
	private Bucket<K,V>[] table;			// 해시 테이블

	// 생성자
	public OpenHash(int size) {
		try {
			table = new Bucket[size];
			for (int i = 0; i < size; i++)
				table[i] = new Bucket<K,V>();
			this.size = size;
		} catch (OutOfMemoryError e) {		// 테이블을 생성할 수 없음
			this.size = 0;
		}
	}

	// 해시 값을 구함
	public int hashValue(Object key) {
		return key.hashCode() % size;
	}

	// 재해시값을 구함
	public int rehashValue(int hash) {
		return (hash + 1) % size;
	}

	// 키 값 key를 갖는 버킷의 검색
	private Bucket<K,V> searchNode(K key) {
		int hash = hashValue(key);				// 검색할 데이터의 해시값
		Bucket<K,V> p = table[hash];			// 선택 버킷

		for (int i = 0; p.stat != Status.EMPTY && i < size; i++) {
			if (p.stat == Status.OCCUPIED && p.getKey().equals(key))
				return p;
			hash = rehashValue(hash);			// 재해시
			p = table[hash];
		}
		return null;
	}

	// 킷값 key를 갖는 요소의 검색 (데이터를 반환)
	public V search(K key) {
		Bucket<K,V> p = searchNode(key);
		if (p != null)
			return p.getValue();
		else
			return null;
	}

	// 키 값 key, 데이터 data를 갖는 요소의  추가
	public int add(K key, V data) {
		if (search(key) != null)
			return 1;							// 이 키 값은 이미 등록됨

		int hash = hashValue(key);				// 추가할 데이터의 해시 값
		Bucket<K,V> p = table[hash];			// 선택 버킷
		for (int i = 0; i < size; i++) {
			if (p.stat == Status.EMPTY || p.stat == Status.DELETED) {
				p.set(key, data, Status.OCCUPIED);
				return 0;
			}
			hash = rehashValue(hash);			// 재해시
			p = table[hash];
		}
		return 2;								// 해시 테이블이 가득 참
	}

	// 키 값 key를 갖는 요소의 삭제
	public int remove(K key) {
		Bucket<K,V> p = searchNode(key);		// 선택 버킷
		if (p == null)
			return 1;							// 이 키 값은 등록되지 않음

		p.setStat(Status.DELETED);
		return 0;
	}

	// 해시 테이블을 덤프
	public void dump() {
		for (int i = 0; i < size; i++) {
			System.out.printf("%02d ", i);
			switch (table[i].stat) {
			 case OCCUPIED :
				System.out.printf("%s (%s)\n",
										table[i].getKey(), table[i].getValue());
				break;

			 case EMPTY :
			 	System.out.println("-- 미등록 --");	break;

			 case DELETED :
			 	System.out.println("-- 삭제 마침 --");	break;
			}
		}
	}
}

     */
}
