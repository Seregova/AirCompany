import planes.ExperimentalPlane;
import models.MilitaryType;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.Plane;

import java.util.*;

// version: 1.1
// made by Vitali Shulha
// 4-Jan-2019

public class Airport {
    private List<? extends Plane> planes;

    List<PassengerPlane> getPassengerPlane() {
        List<? extends Plane> allPlanes = this.planes;
        List<PassengerPlane> passengerPlane = new ArrayList<>();
        for (Plane plane : allPlanes)
            if (plane instanceof PassengerPlane) {
                passengerPlane.add((PassengerPlane) plane);
            }
        return passengerPlane;
    }

    List<MilitaryPlane> getMilitaryPlane() {
        List<MilitaryPlane> militaryPlane = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof MilitaryPlane) {
                militaryPlane.add((MilitaryPlane) plane);
            }
        }
        return militaryPlane;
    }

    PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlanes = getPassengerPlane();
        PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);
        for (PassengerPlane passengerPlane : passengerPlanes) {
            if (passengerPlane.getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
                planeWithMaxCapacity = passengerPlane;
            }
        }
        return planeWithMaxCapacity;
    }

    List<MilitaryPlane> getTransportMilitaryPlanes() {
        List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getMilitaryPlane();
        for (MilitaryPlane plane : militaryPlanes) {
            if (plane.getMilitaryType() == MilitaryType.TRANSPORT) {
                transportMilitaryPlanes.add(plane);
            }
        }
        return transportMilitaryPlanes;
    }

    List<MilitaryPlane> getBomberMilitaryPlanes() {
        List<MilitaryPlane> bomberMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getMilitaryPlane();
        for (MilitaryPlane plane : militaryPlanes) {
            if (plane.getMilitaryType() == MilitaryType.BOMBER) {
                bomberMilitaryPlanes.add(plane);
            }
        }
        return bomberMilitaryPlanes;

    }

    List<ExperimentalPlane> getExperimentalPlane() {
        List<ExperimentalPlane> experimentalPlane = new ArrayList<>();
        for (Plane plane : experimentalPlane) {
            if (plane instanceof ExperimentalPlane) {
                experimentalPlane.add((ExperimentalPlane) plane);
            }
        }
        return experimentalPlane;
    }

    Airport sortByMaxDistance() {
        planes.sort(new Comparator<Plane>() {
            public int compare(Plane o1, Plane o2) {
                return o1.maxFlightDistance() - o2.maxFlightDistance();
            }
        });
        return this;
    }

    //Sorts by max speed
    //@return Airport

     Airport sortByMaxSpeed() {
        planes.sort(new Comparator<Plane>() {
            public int compare(Plane o1, Plane o2) {
                return o1.maxSpeed() - o2.maxSpeed();
            }
        });
        return this;
    }

    Airport sortByMaxLoadCapacity() {
        planes.sort(new Comparator<Plane>() {
            public int compare(Plane o1, Plane o2) {
                return o1.maxLoadCapacity() - o2.maxLoadCapacity();
            }
        });
        return this;
    }

    List<? extends Plane> getPlanes() {
        return planes;
    }

    void print(Collection<? extends Plane> collection) {
        for (Plane plane : collection) {
        }
    }

    Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + planes.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Airport)) return false;
        Airport airport = (Airport) o;
        return Objects.equals(planes, airport.planes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planes);
    }
}
