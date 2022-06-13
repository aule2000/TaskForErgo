import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {PersonListComponent} from './person-list/person-list.component';

const routes: Routes = [
  // { path: '', redirectTo: 'view-person', pathMatch: 'full' },
  { path: 'view-person', component: PersonListComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
