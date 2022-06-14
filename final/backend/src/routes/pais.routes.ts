import { Router } from "express";

import { createPaisController } from "../modules/pais/useCases/createPais";
import { deletePaisController } from "../modules/pais/useCases/deletePais";
import { listPaisesController } from "../modules/pais/useCases/listPaises";
import { updatePaisController } from "../modules/pais/useCases/updatePais";

const paisesRoutes = Router();

paisesRoutes.get("/", (request, response) => {
  return listPaisesController.handle(request, response);
});

paisesRoutes.post("/", (request, response) => {
  return createPaisController.handle(request, response);
});

paisesRoutes.patch("/:id", (request, response) => {
  return updatePaisController.handle(request, response);
});

paisesRoutes.delete("/:id", (request, response) => {
  return deletePaisController.handle(request, response);
});

export { paisesRoutes };
