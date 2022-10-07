import {Category} from "./category";

export interface Product {
  id?: number;
  name?: string;
  price?: number;
  produce?: string;
  category: Category;
}
