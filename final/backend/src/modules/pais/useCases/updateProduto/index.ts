import { PaisRepository } from "../../repositories/PaisRepository";
import { UpdatePaisController } from "./UpdatePaisController";
import { UpdatePaisUseCase } from "./UpdatePaisUseCase";

const paisRepository = PaisRepository.getInstance();
const updatePaisUseCase = new UpdatePaisUseCase(paisRepository);
const updatePaisController = new UpdatePaisController(
  updatePaisUseCase
);

export { updatePaisController };
