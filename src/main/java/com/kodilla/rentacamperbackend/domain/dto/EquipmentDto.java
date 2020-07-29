package com.kodilla.rentacamperbackend.domain.dto;

import com.kodilla.rentacamperbackend.domain.Camper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EquipmentDto {
    private Long id;
    private String description;
    private boolean bedSet;
    private boolean towelSet;
    private boolean bikeRack;
    private boolean childSeat;
    private boolean kitchenKit;
    private boolean snowChains;
    private boolean winterTire;
    private List<Camper> camperList;

    public static class EquipmentDtoBuilder {
        private Long id;
        private String description;
        private boolean bedSet;
        private boolean towelSet;
        private boolean bikeRack;
        private boolean childSeat;
        private boolean kitchenKit;
        private boolean snowChains;
        private boolean winterTire;
        private List<Camper> camperList;

        public EquipmentDtoBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public EquipmentDtoBuilder description(String description) {
            this.description = description;
            return this;
        }

        public EquipmentDtoBuilder bedSet(boolean bedSet) {
            this.bedSet = bedSet;
            return this;
        }

        public EquipmentDtoBuilder towelSet(boolean towelSet) {
            this.towelSet = towelSet;
            return this;
        }

        public EquipmentDtoBuilder bikeRack(boolean bikeRack) {
            this.bikeRack = bikeRack;
            return this;
        }

        public EquipmentDtoBuilder childSeat(boolean childSeat) {
            this.childSeat = childSeat;
            return this;
        }

        public EquipmentDtoBuilder kitchenKit(boolean kitchenKit) {
            this.kitchenKit = kitchenKit;
            return this;
        }

        public EquipmentDtoBuilder snowChains(boolean snowChains) {
            this.snowChains = snowChains;
            return this;
        }

        public EquipmentDtoBuilder winterTire(boolean winterTire) {
            this.winterTire = winterTire;
            return this;
        }

        public EquipmentDtoBuilder camperList(List<Camper> camperList) {
            this.camperList = camperList;
            return this;
        }

        public EquipmentDto build() {
            return new EquipmentDto(id, description, bedSet, towelSet, bikeRack, childSeat, kitchenKit, snowChains, winterTire, camperList);
        }
    }
}
