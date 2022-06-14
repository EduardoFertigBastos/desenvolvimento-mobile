import { PaisRepository } from "../../repositories/PaisRepository";
import { DeletePaisController } from "./DeletePaisController";
import { DeletePaisUseCase } from "./DeletePaisUseCase";

const paisRepository = PaisRepository.getInstance();
const deletePaisUseCase = new DeletePaisUseCase(paisRepository);
const deletePaisController = new DeletePaisController(
  deletePaisUseCase
);

export { deletePaisController };
