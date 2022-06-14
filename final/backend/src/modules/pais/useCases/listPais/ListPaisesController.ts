import { Request, Response } from "express";

import { ListPaisesUseCase } from "./ListPaisesUseCase";

class ListPaisesController {
  constructor(private listPaisesUseCase: ListPaisesUseCase) {}

  handle(request: Request, response: Response): Response {
    const all = this.listPaisesUseCase.execute();

    return response.json(all);
  }
}

export { ListPaisesController };
