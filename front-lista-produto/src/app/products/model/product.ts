import { technology } from './technology';
export interface Product {
    
    _id: String;
    name: String;
    targetMarket: String;
    description: String;
    technologies: Array<technology>;

}

