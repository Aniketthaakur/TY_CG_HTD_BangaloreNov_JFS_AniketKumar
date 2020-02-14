import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filterProducts'
})
export class FilterProductsPipe implements PipeTransform {

  transform(products: any, search: string): any {
    if (search === undefined) {
      return products;
    } else {
      return products.filter((product, index) => {
        return product.pname.toLowerCase().includes(search.toLowerCase());
      });
    }
  }

}
