# Stream 

## 특징
- 파이프라인 구조로 이루어진다.
- 터미널 오퍼레이션을 만나야 비로소 실행된다
- 스트림 메소드의 입력값에 종류가 여러개 있다.

## Terminal Operation
- 컴파일러가 TO를 만나기 전까지 스트림 메소드는 실행되지 않음.
- TO를 만나는 순간 위쪽 파이프라인의 순서대로 실행됨

## Short Circuit evaluation
- 만약 조건문 안에 두가지 조건이 있다고 하자
- 두 번째 조건이 정말 말도 안되는 조건이더라도 만약 첫 번째 조건에서 걸러지면 두 번째 조건을 보지도 않음.
- 컴파일러는 순차적으로 실행되기 때문에.

## Int Stream
- IntStream일 경우 average, sum, max, min, summaryStatistics(이것도 변환) 사용가능
- 출력할 때는 getAsDouble() 등으로 반환받으면 됨.
- 여기서 summaryStatistics로 한번더 변환시 getAverage, getCount, getMax 등등으로 사용가능 (바로 반환)

|메소드|설명|
|---|---|
|.mapToInt(e->e)|스트림<Int>를 Int스트림으로 변환 (다른 자료형도 가능) / Int스트림의 계산 메소드를 편하게 사용하려고 변환하는 것.|
|.boxed()|Int스트림을 스트림<Int>로 변환 (다른 자료형도가능)|

<br>

## Stream의 메소드 정리

>### 입력값 없는 메소드 

|메소드|설명|
|---|---|
| .findFirst()| 스트림의 가장 처음 인자 반환 (트리구조라 가장 최소값임)|
| .get()| reduce나 max 같이 값이 딱 하나 나오는 메소드 뒤에 사용. 값반환|
| .distinct()|중복 제거하기 |
|.parallel() | 스트림을 병렬적으로 변환 (parrellelStream으로 변환)|
|.isParallel() |병렬 스트림이면 true 반환 |
| .sequential()|스트림을 일반(직렬)스트림으로 변환 (그냥 stream) |
|.isSequential()|일반 스트림이면 true 반환|
|.boxed()|Int스트림을 스트림<Int>로 변환 (다른 자료형도가능)|

<br>

>### 입력값이 e인 메소드

|메소드|설명|
|---|---|
|.orElse()|입력값 or 인자 존재시 반환...?|
|.limit()|처음부터 입력값(포함)까지 저장하고 뒤에 나머지 버림|
|.skip()|처음부터 입력값(포함)까지 버리고 뒤에 나머지 저장|
|.close()|스트림을 닫는다.|
|.onClose(러너블)|입력으로 러너블을 받음 / TO가 스트림을 종료시켜도 스트림을 close시키는건 아님. / 따라서 .close()로 스트림이 닫힐 때 비로소 실행됨|

<br>

>### Function : e -> e / 값 하나를 받고 하나를 리턴하는 람다식

|메소드|설명|
|---|---|
|.map()|스트림 원소를 가공|
|.flatMap()|스트림 원소를 가공 후 다시 스트림으로 반환. -> 모두 풀어버림.|
|.mapToInt(e->e)|스트림<Int>를 Int스트림으로 변환 (다른 자료형도 가능)|
|.flatMapToInt()|최종은 인트스트림이 반환되야함 / 인자 -> 스트림 -> Int스트림 / ex) e -> e.getValue().stream().mapToInt(i -> i)|

<br>

>### Predicate : e -> bool / bool 값 리턴되는 조건 람다식

|메소드|설명|
|---|---|
|.filter()|조건을 만족하는 인자만 저장|
|.anyMatch()|조건을 만족하는 인자가 하나라도 있을 경우 true반환|
|.noneMatch()|조건을 만족하는 인자가 하나도 없을 경우 true 반환|
|.takeWhile()|조건 범위에 해당하는 인자를 모두 저장.|
|.dropWhile()|조건 범위에 해당하는 인자를 모두 버림|

<br>

>### Consumer : e -> 소비 / 리턴 없이 모두 소비되는 람다식

|메소드|설명|
|---|---|
|.forEach()|TO. 한번 사용하면 스트림 사용 불가|
|.ifPresent()|TO. 해당 인자가 존재시 발동됨 / 입력값 없어도 사용가능|
|.peek()|forEach와 비슷하나 소비하고도 계속 스트림 사용가능.|

<br>

>### BinaryOperator : e1, e2 -> e / 값 두 개를 입력받고 하나만 리턴하는 람다식

|메소드|설명|
|---|---|
|.reduce()|람다식에서 결과값 하나 나오면 하나만 저장, 최종적으로 값은 하나만 남게됨|

<br>

>### Compartaor : e1, e2 -> 1,0,-1 / 값 두 개를 입력받아 비교 후 1, 0, -1을 리턴하는 람다식

|메소드|설명|
|---|---|
|.max()|람다식에서 두 인자중 어떤게 더 큰지 정보를 받아서 큰것만 저장 -> 마지막엔 값이 하나만 남는다.|
|.min()|작은것만 저장|
|.sorted()|입력값 없이 사용하면 오름차순 정렬됨. / Compartor로 정렬기준 설정가능.|

<br>

>### Supplier : () -> 자료구조 / 스트림을 다른 자료구조로 바꿔 리턴하는 람다식

|메소드|설명|
|---|---|
|.toArray()|스트림을 배열로 변환|

<br>

---

# Collectors

## R Collector
- collect()의 기본 입력값임.
- Collector == Supplier, Accumulaor, Combiner 세가지로 이루어져있음 
- Supplier : () -> 자료구조 / 형을 변환해주고
- Accumulaor(BiConsumer) : (변환자료형,e) -> 소비 / 변환된 자료형에 인자를 넣는다
- Combiner(BiConsumer) : (e1,e2) -> 소비 / 두 변환된 자료형을 합치는 과정

## built-in Collector
- Function.identity() == e->e
- Classifier(Function) : key를 정의
- mapFactory(Supplier) : 반환되는 자료형을 정의
- downstream(Collector) : value(리스트)를 가지고 계산, 조건을 달아서 value를 가공

## toMap Collector
- Default 반환값은 Map<키 자료형, 원소 리스트>
- 그루핑은 value를 리스트에 일단 때려박는데(조작이 불가), toMap에선 value를 정의해줄 수 있다
- KeyMapper(Function) : key를 정의
- valueMapper(Function) : value를 정의 (자료형 바꾸던가...)
- merge(BinaryOperator) : 두 개의 정의된 value를 가지고 합치고 하나의 value를 반환
- Supplier : 반환되는 자료형을 정의

## teeing Collector
- 컬렉터 두 개를 합치고 싶을 때 사용
- Collector1
- Collector2
- merge(BinaryOperator) : 위의 두 컬렉터를 받아서 합친 후 원하는 형태로 반환하면된다. 

## Collectors 메소드 정리

>### 입력값 없는 메소드 

|메소드|설명|
|---|---|
|.toList()|스트림을 리스트로 반환|
|.toSet()|스트림을 집합으로 반환|

<br>

>### 입력값이 e인 메소드

|메소드|설명|
|---|---|
|.joining()|인자들을 모두 합쳐 문자열로 반환 -> (중간구분자, 시작, 끝)|

<br>

>### BinaryOperator : e1, e2 -> e / 값 두 개를 입력받고 하나만 리턴하는 람다식

|메소드|설명|
|---|---|
|.reducing(기본값, BinaryOperator)| 기본값이 인덱스 0의 값이라고 생각하면 됨 / 무조건 기본값 한번 껴서 계산함|

<br>

>### Compartaor : e1, e2 -> 1,0,-1 / 값 두 개를 입력받아 비교 후 1, 0, -1을 리턴하는 람다식

|메소드|설명|
|---|---|
|.maxBy(C)|큰것만 저장|
|.minBy(C)|작은것만 저장|

<br>

>### Supplier : () -> 자료구조 / 스트림을 다른 자료구조로 바꿔 리턴하는 람다식

|메소드|설명|
|---|---|
|toCollection(S)|바꾸고 싶은 자료구조를 리턴하는 람다식을 입력해야함.|

<br>

>### R Collector 

|메소드|설명|
|---|---|
|.collect(S, BC, BC)|기본인 R 컬렉터 입력받는다.|

<br>

>### built-in Collector 

|메소드|설명|
|---|---|
|.groupingBy(F, S, C)|Default 반환값은 Map<키 자료형, 원소 리스트> / 키가 여러개 존재 가능|
|.partitioningBy(F, S, C)|Default 반환값은 Map<boolean, 원소 리스트> / 키가 true, false만 존재|
|.mapping(F, C)|키 인자를 받아서 value를 가공한다|
|.filtering(F, C)|조건을 만족하는 키의 value만 가공한다.|

<br>
