package tandem.vizaagro.domain.converters;

import tandem.vizaagro.Entity.IEntityData;

public interface IConvertable {
    IEntityData convertToObject(byte[] buffer);
}
//TODO: Приделать калссам-сущностям Entiry интерфейс Converter