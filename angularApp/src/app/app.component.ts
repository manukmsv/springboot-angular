import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

@Injectable()
export class AppComponent {
  title = 'Angular Rest API';
  imgTitle : any;
  base64Image: any;
  
  constructor(private http: HttpClient){}
  
  ngOnInit() {
	  //https://braincorr.com/rest/rest.php
	let imageNameUrl = 'http://localhost:8080/imgname';
	let imageUrl = 'http://localhost:8080/image';

	this.http.get(imageUrl, { responseType: 'text' }).subscribe(result => {
		//console.log(result);
		this.base64Image = 'data:image/jpg;base64,' + result;
	});

	this.http.get(imageNameUrl, { responseType: 'text' }).subscribe(result => {
		console.log(result);
		this.imgTitle = result;
	});
  }

}
