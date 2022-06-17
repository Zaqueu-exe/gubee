import { Technology } from './technology';
export interface Product {
    
    _id: String;
    name: String;
    targetMarket: String;
    description: String;
    technologie: Technology[];

}

