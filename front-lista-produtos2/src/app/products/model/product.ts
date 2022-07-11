import { Technology } from "./technology";
export interface Product {

  id: String;
  name: String;
  targetMarket: String;
  description: String;
  technologies: Technology[];
}
