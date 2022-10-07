import {FacilityType} from "./facility-type";
import {RentType} from "./rent-type";

export interface Facility {
  id?: number;
  name?: string;
  cost?: number;
  maxPeople?: number;
  area?: number;
  standardRoom?: string;
  descriptionOtherConvenience?: string;
  poolArea?: number;
  numberOfFloors?: number;
  facilityFree?: string;
  facilityId?: FacilityType;
  rentType?: RentType;
}
