import { Technology } from './../model/technology';
import { ProductsService } from './../services/products.service';
import { Product } from './../model/product';
import { Component, Input, OnInit } from '@angular/core';
import { catchError, Observable, of, first, tap } from 'rxjs';
import { MatDialog } from '@angular/material/dialog';
import { ErrorDialogComponent } from 'src/app/shared/components/error-dialog/error-dialog.component';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {
  products$: Observable<Product[]> | undefined;
  displayedColumns = ['name', 'targetMarket', 'description', "technologies"];
  @Input() technologyName: string = '';
  @Input() targetMarketName: string = '';

  //productsService: ProductsService;

  constructor(
    private productsService: ProductsService,
    public dialog: MatDialog) {
    this.findAll()

  }

  saveNameTechnology(valor: string) {
    this.technologyName = valor;

  }

  saveNameTargetMarket(valor: string) {
    this.targetMarketName = valor;

  }

  findAll(): void {
    this.products$ = this.productsService.listAll()
      .pipe(
        catchError(error => {
          this.onError('Erro ao carregar produtos.');
          return of([])
        })
      );
    console.log('teste para rodar os prdoutso')
    console.log(this.products$)
  }

  findByTechnolgy(): void {
    this.products$ = this.productsService.getByTechnology(this.technologyName)
      .pipe(
        catchError(error => {
          this.onError('Erro ao carregar produtos.');
          return of([])
        })
      );
  }

  findByTargetMarket(): void {
    this.products$ = this.productsService.getByTargetMarket(this.targetMarketName)
      .pipe(
        catchError(error => {
          this.onError('Erro ao carregar produtos.');
          return of([])
        })
      );
  }



  onError(errorMSG: string) {
    this.dialog.open(ErrorDialogComponent, {
      data: errorMSG
    });
  }

  ngOnInit(): void {

  }

}
