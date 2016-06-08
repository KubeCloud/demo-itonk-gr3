declare namespace models {
    export interface ICart {
        id: number;
        products: Array<IProduct>;
        price: number;
    }
}
