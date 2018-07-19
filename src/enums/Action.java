package enums;

public enum Action {
	MOVE, JOIN,
	CREATE, LIST, SEARCH, RETRIEVE,
	COUNT, UPDATE, DELETE, LOGIN, 
//return 타입으로 구분한 것임. 
// search -  find some => return 타입이 List<>
// retrieve - find one => return 타입 memberBean
}
