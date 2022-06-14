import { Request, Response } from "express";

import { DeletePaisUseCase } from "./DeletePaisUseCase";

class DeletePaisController {
  constructor(private deletePaisUseCase: DeletePaisUseCase) {}

  handle(request: Request, response: Response): Response {
    const { id } = request.params;

    this.deletePaisUseCase.execute(id);

    return response.send();
  }
}

export { DeletePaisController };
