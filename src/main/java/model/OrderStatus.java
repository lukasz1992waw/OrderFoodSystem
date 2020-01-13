package model;

public enum OrderStatus {
    NOWE,
    DOSTARCZONE,
    ANULOWANE
}


//OrderStatus		[DB ORDER_STATUS]
//        id 			number
//        status			varchar[50]		//nowe, dostarczone, anulowane