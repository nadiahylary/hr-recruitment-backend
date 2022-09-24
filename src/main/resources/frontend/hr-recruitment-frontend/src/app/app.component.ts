import {Component, OnInit} from '@angular/core';
import {Profiles} from "./model/profiles.model";
import {Router} from "@angular/router";
import {ProfileService} from "./service/profiles.service";
import {HttpErrorResponse} from "@angular/common/http";
import { MdbTablePaginationComponent, MdbTableDirective } from 'angular-bootstrap-md';
import {ViewChild, AfterViewInit, ChangeDetectorRef } from '@angular/core';
import {MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit, AfterViewInit{

  elements: Profiles[] = [];
  previous: Profiles[] = [];
  headElements = ['Index', 'Profile Picture', 'Name', 'Category','Profile URL', 'LocationLocation','Description','Experience', 'Current Position','Skills', 'Confirmed Skills'];
  @ViewChild(MdbTablePaginationComponent, {static: true})
  mdbTablePagination: MdbTablePaginationComponent;
  @ViewChild(MdbTableDirective, {static: true})
  mdbTable: MdbTableDirective;

  title = 'hr-recruitment-frontend';
  public profiles: Profiles[] = [];
  /*dataSource = new MatTableDataSource<Profiles>(this.profiles);
  @ViewChild(MatPaginator) paginator: MatPaginator;*/
  constructor(private router: Router, private profilesService: ProfileService, private cdRef: ChangeDetectorRef) { }

  ngOnInit(): void {
    this.getProfiles();
    this.mdbTable.setDataSource(this.profilesService.getAllProfiles());
    /*this.elements = this.mdbTable.getDataSource();
    this.previous = this.mdbTable.getDataSource();*/
    this.mdbTablePagination.setMaxVisibleItemsNumberTo(5);
    this.mdbTablePagination.calculateFirstItemIndex();
    this.mdbTablePagination.calculateLastItemIndex();
    this.cdRef.detectChanges();

    /*this.mdbTable.setDataSource(this.elements);
    this.elements = this.mdbTable.getDataSource();
    this.previous = this.mdbTable.getDataSource();*/
  }
  public getProfiles(): void {
    this.profilesService.getAllProfiles().subscribe(
      (response: Profiles[]) => {
        this.profiles = response;
        console.log(this.profiles);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
    //return this.profiles;
  }

  public searchProfiles({event}: { event: any }): void {
    let searchword = event.target.value
    console.log(searchword);
    const results: Profiles[] = [];
    for (const profile of this.profiles) {
      if (
        profile.category.toLowerCase().indexOf(searchword.toLowerCase()) !== -1
        || profile.linkedin.toLowerCase().indexOf(searchword.toLowerCase()) !== -1
        || profile.description.toLowerCase().indexOf(searchword.toLowerCase()) !== -1
        || profile.Experience.toLowerCase().indexOf(searchword.toLowerCase()) !== -1
        || profile.name.toLowerCase().indexOf(searchword.toLowerCase()) !== -1
        || profile.position.toLowerCase().indexOf(searchword.toLowerCase()) !== -1
        || profile.location.toLowerCase().indexOf(searchword.toLowerCase()) !== -1
        || profile.skills.toLowerCase().indexOf(searchword.toLowerCase()) !== -1
        || profile.clean_skills.toLowerCase().indexOf(searchword.toLowerCase()) !== -1) {
        results.push(profile);
      }
    }
    this.profiles = results;
    if (results.length === 0 || !searchword) {
      this.getProfiles();
    }
  }

  ngAfterViewInit() {
    this.mdbTablePagination.setMaxVisibleItemsNumberTo(5);
    this.mdbTablePagination.calculateFirstItemIndex();
    this.mdbTablePagination.calculateLastItemIndex();
    this.cdRef.detectChanges();
  }
}
