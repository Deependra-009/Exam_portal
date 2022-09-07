import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseurl from './URL';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(
    private http:HttpClient
  ) { }

  public category(){
    return this.http.get(`${baseurl}/category/get-all`);
  }

  public addCategory(category:any){
    return this.http.post(`${baseurl}/category/add`,category);
  }
}
