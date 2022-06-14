import { PaisRepository } from "../../repositories/PaisRepository";
import { ListPaisesController } from "./ListPaisesController";
import { ListPaisesUseCase } from "./ListPaisesUseCase";

const paisRepository = PaisRepository.getInstance();
const listPaisesUseCase = new ListPaisesUseCase(paisRepository);
const listPaisesController = new ListPaisesController(listPaisesUseCase);

export { listPaisesController };
