import {TypeBus} from "./type-bus";
import {Locations} from "./locations";

export interface HomeBus {
  id: string;
  typeBus: TypeBus;
  name?: string;
  goLocations: Locations;
  backLocations: Locations;
  phone?: number;
  email: string;
  startTime?: string;
  endTime?: string;
}
